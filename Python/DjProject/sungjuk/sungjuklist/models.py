from django.db import models

# Create your models here.

class SungjukList(models.Model):
    hakbun = models.CharField(max_length=30, primary_key=True)
    name = models.CharField(max_length=10, blank=True)
    kor = models.IntegerField(blank=True)
    eng = models.IntegerField(blank=True)
    math = models.IntegerField(blank=True)
    sum = models.IntegerField(blank=True)
    avg = models.FloatField(blank=True)
    grade = models.CharField(max_length=5, blank=True)

    def __str__(self):
        return str(self.hakbun) + str(self.name)

